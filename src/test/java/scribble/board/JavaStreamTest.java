package scribble.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import scribble.board.demo.stream.DomainData;

import java.util.List;
import java.util.stream.Stream;

/**
 * 자바 스트림의 특징을 알아보자.
 * 스트림은 지연 연산 (Lazy Evaluation) 을 수행한다.
 * 그럼 지연 연산은 무엇이고 어떤 원리이며 왜 필요할까?
 * => 루프 퓨전 (loop fusion)
 * => 쇼트 서킷 (short circuit)
 */
public class JavaStreamTest {


    @Test
    @DisplayName("for 문법에서 데이터 목록에 접근하는 순서가 즉각 실행일까?")
    void eagerExecutionWithForSyntax() {
        for (DomainData data : List.of(new DomainData("first"), new DomainData("second"), new DomainData("third"))) {
            data.runA();
            data.runB();
            data.runC();
        }
    }

    @Test
    void test() {
        Stream.of(new DomainData("first"), new DomainData("second"), new DomainData("third"))
                .peek(DomainData::runA)
                .peek(DomainData::runB)
                .forEach(DomainData::runC);
    }
}
