package jp.org.mhirakaw;

import org.junit.Test
import org.junit.Before
import org.gmock.GMockTestCase

class GreeterTest extends GMockTestCase {
    
    Greeter target
    
    @Before
    def void setUp() {
        target = new Greeter()
    }
    
    @Test
    def void test_helloWithName() {
        assert "hello Munenori" == target.helloWithName("Munenori")
    }
    
    @Test
    def void test_goodGreetingWithName() {
        GreetSupporter gsMock = mock(GreetSupporter)
        gsMock.greetByTime().returns("Congratulation")
        target.setGreetSupporter(gsMock);
        play {
            assert "Congratulation Munenori" == target.goodGreetingWithName("Munenori")
        }
    }
    
}
