package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * Test for {@link DriverSnapshotHandler}.
 */
public class DriverSnapshotHandlerTest {
    
    private static final String MOCKED_URL = "MockedURL";
    private FormatterService formatter;
    
    @SuppressWarnings("javadoc")
    @Before
    public void setUp() {
        formatter = mock(FormatterService.class);
        setMock(formatter);
        when(formatter.formatTachoIcon()).thenReturn(MOCKED_URL);
    }
    
    /**
     * Remove the mocked instance from the class. It is important to clean up the class, because other tests will be confused with the mocked instance.
     * @throws Exception if the instance could not be accessible
     */
    @After
    public void resetSingleton() throws Exception {
       Field instance = FormatterService.class.getDeclaredField("instance");
       instance.setAccessible(true);
       instance.set(null, null);
    }
    
    /**
     * Set a mock to the {@link FormatterService} instance
     * Throws {@link RuntimeException} in case if reflection failed, see a {@link Field#set(Object, Object)} method description.
     * @param mock the mock to be inserted to a class
     */
    private void setMock(FormatterService mock) {
        try {
            Field instance = FormatterService.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, mock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test method for {@link com.example.DriverSnapshotHandler#getImageURL()}.
     */
    @Test
    public void testFormatterServiceIsCalled() {
        DriverSnapshotHandler handler = new DriverSnapshotHandler();
        String url = handler.getImageURL();

        verify(formatter, atLeastOnce()).formatTachoIcon();
        assertEquals(MOCKED_URL, url);
    }

}
