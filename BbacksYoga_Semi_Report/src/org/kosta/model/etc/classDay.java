package org.kosta.model.etc;

public enum classDay {
	mon("0"), tue("1"), wen("2"), thu("3"), fri("4"), sat("5"),
	MON("0"), TUE("1"), WEN("2"), THU("3"), FRI("4"), SAT("5"),
	wed("2"), WED("2") ;
	
    final private String name;
    
    private classDay(String name) { //enum에서 생성자 같은 역할
        this.name = name;
    }
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
    
    
}
