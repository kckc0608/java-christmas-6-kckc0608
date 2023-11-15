package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트3() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트4() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-21");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트3() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_없는_메뉴_주문() {
        assertSimpleTest(() -> {
            runException("3", "제로사이다-20");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_음료만_주문1() {
        assertSimpleTest(() -> {
            runException("3", "레드와인-1");
            assertThat(output()).contains(
                "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
                "[ERROR] 음료만 주문할 수 없습니다."
            );
        });
    }

    @Test
    void 주문_예외_테스트_음료만_주문2() {
        assertSimpleTest(() -> {
            runException("3", "레드와인-1,샴페인-1");
            assertThat(output()).contains(
                "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
                "[ERROR] 음료만 주문할 수 없습니다."
            );
        });
    }

    @Test
    void 주문_예외_테스트_주문_갯수_초과() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-10,샴페인-11");
            assertThat(output()).contains(
                "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
                "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."
            );
        });
    }

    // TODO: 주말인데 주말에 할인 적용되는 상품을 주문하지 않았을 경우, 0원이라도 할인 혜택 출력에 포함되어야 함.

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
