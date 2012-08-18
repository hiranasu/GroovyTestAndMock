package jp.org.mhirakaw;

import org.junit.Test
import org.junit.Before
import org.gmock.GMockController
import org.gmock.GMockTestCase
import org.gmock.WithGMock

/**
 * Greeterのテストクラス
 * 
 * GMockTestCaseをextendsすると、@Testが効かなくなり、
 * testのprefixがついたテストケースしか実行されず、
 * jUnit4の恩恵を受けられないので、@WithGmockを利用している。
 * 
 * メソッド名を文字列にすると、playが実行できなくなるので、
 * 文字列にはできない。
 * 例：def void "とあるテストケース"() { }

 * 
 * @author hiranasu
 *
 */
@WithGMock
class GreeterTest {
    
    Greeter target
    GMockController gmc
    
    @Before
    def void setUp() {
        target = new Greeter()
        gmc = new GMockController()
    }
    
    @Test
    def void helloWithName() {
        assert "hello Munenori" == target.helloWithName("Munenori")
    }
    
    @Test
    def void goodGreetingWithName() {
        GreetSupporter gsMock = gmc.mock(GreetSupporter)
        gsMock.greetByTime().returns("Congratulation")
        target.greetSupporter = gsMock
        gmc.play {
            assert "Congratulation Munenori" == target.goodGreetingWithName("Munenori")
        }
    }
    
}
