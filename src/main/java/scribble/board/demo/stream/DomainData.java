package scribble.board.demo.stream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DomainData {

    String name;

    public void runA() {
        System.out.printf("%s's operation A has done. %n", name);
    }

    public void runB() {
        System.out.printf("%s's operation B has done. %n", name);
    }

    public void runC() {
        System.out.printf("%s's operation C has done. %n", name);
    }

    @Override
    public String toString() {
        return "DomainData {" + name + "}";
    }
}
