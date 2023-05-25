import java.util.Scanner; 

public class pollsWithoutMethod {
    public static void main(String[] args) {    
        boolean pollgo = true;
        Scanner scanner = new Scanner(System.in);

       while(pollgo){
            System.out.println("P.설문시작 | Q.종료");
            System.out.println("--------------------------------------------------------");
            System.out.print("선택> ");
            String letter = scanner.nextLine();
            System.out.println("--------------------------------------------------------");
                     
            switch (letter){
                case "P": //P입력할때 
                    System.out.println("▶ 설문시작 ");
                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    String[] names = {name};//이름입력받기 
                    int answernum=0; //답변넣을 배열 숫자
                    int i=0; //답변 출력위한 i 초기화 
                
                        String [][] polls = {{"1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?"},
                                            {"(1)전혀 아니다","(2)아니다","(3)그렇다","(4)매우그렇다"},
                                            {"2. 강의의 내용은 체계적이고 성의있게 구성되었는가?"},
                                            {"(1)전혀 아니다","(2)아니다","(3)그렇다","(4)매우그렇다"},
                                            {"3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?"},
                                            {"(1)전혀 아니다","(2)아니다","(3)그렇다","(4)매우그렇다"},
                                            {"4. 강의 진행 속도는 적절하였는가?"},
                                            {"(1)전혀 아니다","(2)아니다","(3)그렇다","(4)매우그렇다"},
                                            }; //질문,보기 배열

                    int[] answers = new int[polls.length/2]; //답 저장할 배열

                        for(int second=0; second<polls.length; second=second+2) //질문이 배열길이만큼까지 , [0],[2],[4] 에 있으니 +2 로 해줌
                        {
                            System.out.println(polls[second][0]);    //질문   00, 20, 40 60 순으로 출력 

                            for(int third=0;third<polls.length/2; third=third+1) //poll.lenght길이의 반만큼까지만 
                            {      
                                System.out.print(polls[second+1][third]+","); //보기출력  
                            }  

                            System.out.print("\n답) "); //답을 입력하시오 문구 출력
                            answers[answernum] = scanner.nextInt(); //answer배열에 답 입력받기
                            answernum =  answernum+1; // answer배열공간 1씩 증감           
                        }

                        System.out.println("---------------------설문 종료--------------------------");

                        System.out.print("이름) ");  //이름 질문1 질문2 질문3 질문4 보기 for문으로 출력 
                        for (i = 1; i < 5; i++) {
                            System.out.print("   질문("+(i)+")");
                        } 
                        System.out.print( "\n"+name); // 입력한 이름 출력 

                        for (i = 0; i < 4; i++) {      //번호별 답 출력하기 
                        System.out.print("       "+answers[i]+"   ");
                        }    
                        
                        System.out.println("\n---------------------통계 종료--------------------------");

                    break;

                case "Q": //Q입력할때 
                        System.out.println("▶ 종료 ");
                        System.out.println("이용해주셔서 감사합니다!");
                        pollgo = false; //pollgo를 false로 주고 프로그램 전체 종료시킴
                    break ;

            }
        }
    }
}
