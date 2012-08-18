package jp.org.mhirakaw;

import org.junit.Test
import org.junit.Before
import org.gmock.GMockController
import org.gmock.GMockTestCase
import org.gmock.WithGMock

/**
 * Greeter�̃e�X�g�N���X
 * 
 * GMockTestCase��extends����ƁA@Test�������Ȃ��Ȃ�A
 * test��prefix�������e�X�g�P�[�X�������s���ꂸ�A
 * jUnit4�̉��b���󂯂��Ȃ��̂ŁA@WithGmock�𗘗p���Ă���B
 * 
 * ���\�b�h���𕶎���ɂ���ƁAplay�����s�ł��Ȃ��Ȃ�̂ŁA
 * ������ɂ͂ł��Ȃ��B
 * ��Fdef void "�Ƃ���e�X�g�P�[�X"() { }

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
