The project describes how to mock static field by example of singleton instance.

The main idea is:
* injecting of mocked object to a static field before a test
* and removing of the mocked object from a static field after a test.

See com.example.DriverSnapshotHandlerTest

```
    
    /**
     * Set a mock to the {@link FormatterService} instance
     * Throws {@link RuntimeException} in case if reflection failed, see a {@link Field#set(Object, Object)} method description.
     * @param mock the mock to be inserted to a class
     */
    private void setMock(FormatterService mock) {
        Field instance;
        try {
            instance = FormatterService.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, mock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
```