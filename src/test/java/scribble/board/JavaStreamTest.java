package scribble.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import scribble.board.demo.stream.DomainData;

import java.util.List;
import java.util.stream.Stream;

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
