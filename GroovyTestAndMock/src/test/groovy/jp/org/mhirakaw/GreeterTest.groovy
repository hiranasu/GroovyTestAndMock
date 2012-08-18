package jp.org.mhirakaw;

import org.junit.Test
import org.junit.Before

class GreeterTest {
    
    Greeter target
    
    @Before
    def void setUp() {
        target = new Greeter()
    }
    
    @Test
    def void test_helloWithName() {
        assert "hello Munenori" == target.helloWithName("Munenori")
    }
    
}
