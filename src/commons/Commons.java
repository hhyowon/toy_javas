package commons;

import java.util.UUID;

public class Commons {
     public String generateUUID() { //유니크아이디 생성
        return UUID.randomUUID().toString(); //리턴타입 스트링으로 변경 
    }
    
}
