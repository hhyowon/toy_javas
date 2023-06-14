import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

//import com.mysql.cj.sasl.ScramSha1SaslClient;

//import cars.Car;


public class PollsWithDB {
    public static void main(String[] args) {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://127.0.0.1:3306/db_cars";
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String query =""; 

            /*  작업 키 입력  */
            Scanner scanner = new Scanner(System.in);
            String workkey = "P"; // 작업키 workkey를 초기값 P로 선언
            while(!workkey.equals("E")){ //'E'가 아닐때까지 무한루프 
                System.out.println("------ 작동 key ------\n(E)xit :  종료 \n(P)oll : 설문조사\n(S)tatistic : 통계");
                System.out.print("선택입력 : ");
                 workkey = scanner.nextLine(); // 키 입력 scanner 

                 /* 'O'입력시 차 이름명단 나오는 옵션 */
                 if(workkey.equals("P")){ 
                    System.out.println("- 설문자 가능 명단(가입 완료)");
                     // 예삔커벨이 할일 설문자 가능 명단 sql에서 가져오기
                     // 출력예시 : 1. 홍길동, 2.장길산, 3.신사임당, 4. 깅예빈  
                     // 어제 cars웅앵이랑, connectDB 참조하면서 sql 가져오는 코드 작성하기
                     // 이름옆에 숫자는 예빈쓰가 number 변수 선언해야함. number 옆에 . 도 출력되게 설정 
                     // while문 사용해서 모든 설문자 출력하게 하기! 
                     
                     // query = "SELECT~~~예삔커벨이 짤 쿼리 " + //

                    int memNum=1; //설문자 번호
                    boolean validInput = false; //유효한 입력 여부 변수  

                    while (!validInput) { // 똑바로 입력 할때까지 반복 
                    System.out.print("설문자 번호 입력 : ");
                    memNum = scanner.nextInt(); //해당 설문자 번호 입력
                        if(memNum > 4) //최대 4명이니깐 4 이상 숫자 입력시 Error 메시지 출력
                        {
                            System.out.println("-Error- 확인 후 입력 필요 ");
                        }else {
                                validInput = true; //유효하면 true 
                        }
                    System.out.println("-- 설문시작 -- ");
                }
                //         query = "SELECT T_FAC.COMPANY, T_CAR_INFOR.CAR_NAME\n" + //
                //                 "   , T_CAR_INFOR.CAR_INFOR_ID\n" + //
                //                 "FROM (factorys AS T_FAC\n" + //
                //                 "   inner JOIN car_infors AS T_CAR_INFOR\n" + //
                //                 "    ON T_FAC.COMPANY_ID = T_CAR_INFOR.COMPANY_ID)\n" ;
                                
                //     ResultSet resultSet = statement.executeQuery(query); //statemane 객체를 사용해서 select문 실행하고 결과 resultset에 저장함 
                //     int number = 1; //번호를 나타내는 변수 
                //     Statement statement2 = connection.createStatement(); //두번째 쿼리 실행위해 생성
                //     ResultSet resultSet2; //두번째 쿼리 결과 저장위해 변수 선언 
                //     String query2; // 두번째 쿼리 저장위한 문자열 변수 선언 
                //     HashMap< String, String> carNumberMap = new HashMap<>(); //자동차 번호를 저장하기 위한 해시맵 생성,재활용위함

                //   while (resultSet.next()) { //resultSet 값 있을 때까지 반복 루프 
                //         System.out.print(number + "." +
                //             resultSet.getString("COMPANY") + " - " +
                //             resultSet.getString("CAR_NAME") + ": "); //번호, 회사명, 자동차 이름 출력 
                        
                //         String carInforId = resultSet.getString("CAR_INFOR_ID"); //재활용위해 변수에 치환시킴

                //         query2 = "SELECT T_OPT_INFO.OPTION_NAME\n" + //
                //                 "FROM option_infors AS T_OPT_INFO\n" + //
                //                 "\tINNER JOIN `options` AS T_OPTS\n" + //
                //                 "    ON T_OPT_INFO.OPTION_INFOR_ID = T_OPTS.OPTION_INFOR_ID\n" + //
                //                 "    AND T_OPTS.CAR_INFOR_ID = '"+carInforId+"'";
                //         resultSet2 = statement2.executeQuery(query2);
                //         while(resultSet2.next()){
                //             System.out.print(resultSet2.getString("OPTION_NAME")+",");
                //         }
                //         number = number + 1;
                //         System.out.println();
                //     }
                // //    차량 번호 입력 
                //     System.out.print("- 차 이름 명단 : ");
                //     String CarNumber = scanner.nextLine(); //차번호 입력 받기 
                //     System.out.println("차명 PK : " + carNumberMap.get(CarNumber)); //해시맵에서 입력받은 차 번호에 해당하는 차명PK가져와 출력
                 
                //     System.out.println("- 선택 가능 옵션들");
                //     query = "SELECT OPTION_INFOR_ID, OPTION_NAME\r\n" + //
                //             "FROM option_infors ";
                //     resultSet = statement.executeQuery(query); //옵션 select 쿼리 결과값 저장 
                //     number = 1; //옵션번호 나타내는 변수 

                //     HashMap<String, String> carOptionInfor = new HashMap<>(); //옵션정보를 저장하기 위한 해시맵 생성 
                //     while(resultSet.next()) { 
                //         System.out.print(number +"."+resultSet.getString("OPTION_NAME")+", "); // 1.옵션1, 2.옵션2 ... 이렇게 나오게 출력
                //         carOptionInfor.put(String.valueOf(number), resultSet.getString("OPTION_INFOR_ID")); //해시맵에 옵션번호, 옵션 정보ID  저장 
                //         number = number + 1;    // String.valueOf : int형인 number 변수 문자열로 변환함 
                //     }
                //     System.out.println();

                //     System.out.print(" - 추가 옵션 선택 : ");
                //     String optionNumber = scanner.nextLine(); //옵션번호 입력 
                //     System.out.println(carNumberMap.get(CarNumber)+", "+carOptionInfor.get(optionNumber));// <해쉬맵에서 가져옴> 선택한 자동차의 이름, 선택한 옵션 정보 출력
                        
                //     String carPk = carNumberMap.get(CarNumber);
                //     String optionPk = carOptionInfor.get(optionNumber);

                //     //delete 옵션
                //     query ="DELETE FROM `OPTIONS`\n" + //
                //             "WHERE CAR_INFOR_ID = '"+carPk+"' AND OPTION_INFOR_ID = '"+optionPk+"'";
                //     int count = statement.executeUpdate(query); //삭제쿼리 실행하고 영향받는 수 저장

                //     //insert 옵션
                //     Commons commons = new Commons(); //Commons 클래스의 인스턴스 생성
                //     String optionId = commons.generateUUID(); //랜덤유니크아이디 값 생성에 optionId에 선언해줌 
         
                //     query = "INSERT INTO `OPTIONS`\n" + //
                //             "(OPTION_ID, CAR_INFOR_ID, OPTION_INFOR_ID)\n" + //
                //             "value\n" + //
                //             "('"+optionId+"', '"+carPk+"', '"+optionPk+"')\n" + //
                //             ";\n" + //
                //             "";
                //     count = statement.executeUpdate(query);


                    /* S입력시 : 통계시작*/
                 } else if(workkey.equals("S")){
                         System.out.println(" - 통계 시작 -");
                         System.out.println(" -- 총 설문자 3명");
                    //      query ="SELECT T_FAC.COMPANY, T_CAR_INFOR.CAR_NAME ,COUNT(*) AS CNT\n" + //
                    // "FROM (factorys AS T_FAC\n" + //
                    // "   inner JOIN car_infors AS T_CAR_INFOR\n" + //
                    // "    ON T_FAC.COMPANY_ID = T_CAR_INFOR.COMPANY_ID)\n" + //
                    // "    inner join `options` AS T_OPTS\n" + //
                    // "    ON T_CAR_INFOR.CAR_INFOR_ID = T_OPTS.CAR_INFOR_ID\n" + //
                    // "GROUP BY T_FAC.COMPANY,  T_CAR_INFOR.CAR_INFOR_ID";

                    // ResultSet resultSet = statement.executeQuery(query);
                    // while (resultSet.next()) {
                    //     System.out.println( 
                    //         resultSet.getString("COMPANY") + "-"+ 
                    //         resultSet.getString("CAR_NAME")+","+ resultSet.getString("CNT"));
                    // }
                
                 
                 } else{
                        System.out.println(" ----- 작업 키 확인 ----"+workkey);
                 }

            }
            
            System.out.println("----- 설문종료 -----");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println();
        }
         System.out.println();
    }
    
}
