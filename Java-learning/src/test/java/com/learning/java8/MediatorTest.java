package com.learning.java8;

import com.learning.java8.learning.designPattern.mediator.Colleague;
import com.learning.java8.learning.designPattern.mediator.ConcreteColleague;
import com.learning.java8.learning.designPattern.mediator.ConcreteMediator;
import com.learning.java8.learning.designPattern.mediator.Mediator;

public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague(mediator, "xiaohong1");
        Colleague colleague2 = new ConcreteColleague(mediator, "xiaohong2");
        Colleague colleague3 = new ConcreteColleague(mediator, "xiaohong3");
        Colleague colleague4 = new ConcreteColleague(mediator, "xiaohong4");
        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        mediator.addColleague(colleague3);
        mediator.addColleague(colleague4);
        colleague2.contact("hello", "xiaohong4", "xiaohong3");
    }
}
