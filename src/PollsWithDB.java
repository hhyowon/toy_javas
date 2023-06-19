import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import commons.Commons;

public class PollsWithDB {
    public static void main(String[] args) {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://127.0.0.1:3306/pollswithdb";
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String query = "";

            /* 작업 키 입력 */
            Scanner scanner = new Scanner(System.in);
            String workkey = "P"; // 작업키 workkey를 초기값 P로 선언
            while (!workkey.equals("E")) { // 'E'가 아닐때까지 무한루프
                System.out.println("------ 작동 key ------\n(E)xit :  종료 \n(P)oll : 설문조사\n(S)tatistic : 통계");
                System.out.print("선택입력 : ");
                workkey = scanner.nextLine(); // 키 입력 scanner
                String usernameId = "";
                HashMap<String, String> userNameMap = new HashMap<>();// 설문자 번호를 저장할 해시맵 생성
                String memNum = "";

             /* 'P'입력시 설문자 가능 명단  */
             if (workkey.equals("P")) {
                    System.out.println("- 설문자 가능 명단(가입 완료)");

                    query = "SELECT USER_NAME,USER_NAME_ID\n" + // 사용자 출력 쿼리
                            "FROM pollswithdb.user";
                    ResultSet resultSet = statement.executeQuery(query); // statemant 객체를 사용해서 select문 실행하고 결과
                                                                         // resultset에 저장함
                    int number = 1; // 번호를 나타내는 변수

                    while (resultSet.next()) { // resultSet 값 있을 때까지 반복 루프
                        System.out.println(number + "." +
                                resultSet.getString("USER_NAME"));
                        number = number + 1;
                        usernameId = resultSet.getString("USER_NAME_ID"); // 재활용위해 변수에 치환시킴
                        userNameMap.put(String.valueOf(number), usernameId);
                    }
                    System.out.println();

                    /* 설문자 번호 입력 확인용 */
                    boolean validInput = false; // 유효한 입력 여부 변수
                    while (!validInput) { // 똑바로 입력 할때까지 반복
                        System.out.print("설문자 번호 입력 : ");
                        memNum = scanner.nextLine(); // 해당 설문자 번호 입력
                        if (Integer.parseInt(memNum) > 4) // 최대 4명이니깐 4 이상 숫자 입력시 Error 메시지 출력
                        {
                            System.out.println("-Error- 확인 후 입력 필요 ");
                        } else {
                            validInput = true; // 유효하면 true
                        }
                        System.out.println("-- 설문시작 -- ");
                    }

                    Statement statement2 = connection.createStatement(); // 두번째 쿼리 실행위해 생성
                    ResultSet resultSet2; // 두번째 쿼리 결과 저장위해 변수 선언
                    String query2; // 두번째 쿼리 저장위한 문자열 변수 선언
                    String answerNumber; // 답항 번호 입력받을 변수
                    HashMap<String, String> answerNumMap = new HashMap<>(); // 답항 저장, 답항 get하기 위한 해시맵 생성

                   /*statistics USER_NAME_ID 삭제 : 선택한 memNum 과 일치하는 USER_NAME_ID 삭제 */ 
                    query = "DELETE FROM statistics\n" +
                            "WHERE USER_NAME_ID = '" + userNameMap.get(memNum) + "'";
                    int count = statement.executeUpdate(query);

                    /* QUESTION 출력 */
                    query = "SELECT QUESTION,QUESTION_ID\n" + //
                            "From pollswithdb.question;\n";
                    resultSet = statement.executeQuery(query); 

                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("QUESTION")); 

                        query2 = "SELECT ANSWER, ANSWER_ID\n" + //
                                "FROM pollswithdb.answer;\n"; // 답항 출력하는 쿼리
                        resultSet2 = statement2.executeQuery(query2);
                        int number_second = 1;
                        while (resultSet2.next()) {
                            System.out.print(resultSet2.getString("ANSWER") + "  ");
                            answerNumMap.put(String.valueOf(number_second), resultSet2.getString("ANSWER_ID"));
                            number_second = number_second + 1; 
                                                               
                        }
                        resultSet2.close();
                        System.out.println();
                        System.out.print("답) ");
                        answerNumber = scanner.nextLine(); // 1,2,3, 답항번호 입력
                      
                        /*INSERT */
                        Commons commons = new Commons(); // Commons 클래스의 인스턴스 생성
                        String QueId = commons.generateUUID(); // 랜덤유니크아이디 값 생성에 QueId에 선언해줌

                        query = "insert into statistics\n" + //
                         "(STATISTICS_ID, USER_NAME_ID, QUESTION_ID, ANSWER_ID)\n"+ // 통계ID, 사용자ID , 설문문항ID , 설문답항ID
                        "values\n" + //
                        "('"+QueId+"', '"+userNameMap.get(memNum)+"', '"
                         +resultSet.getString("QUESTION_ID")+"', '"
                         +answerNumMap.get(answerNumber)+"')";
                        // STATISTICS_ID : 유니크아이디 랜덤으로 줌
                        // USER_NAME_ID : 사용자ID 는 사용할사람 선택 해시맵에서 저장했던 값 get
                        // ANSWER_ID : answerNumMap.get(answerNumber) : answerNumMap에다가 put으로 answeid 값
                        // 넣었으니깐
                        // 답항 선택할때  , answerNumMap.get(answerNumber) 하면 내가 입력한 answerNumber 값이랑 동일한 answer_id의 값이 들어가게됨

                         int result = statement.executeUpdate(query); //쿼리값 저장


                    }  
                    /* S입력시 : 통계시작 */
                } else if (workkey.equals("S")) {
                    System.out.println(" - 통계 시작 -");

                    // 총 설문자 출력
                    System.out.println(" -- 총 설문자  ");
                    query = "SELECT COUNT(DISTINCT USER_NAME_ID) AS TotalCount\r\n" + //
                            "FROM statistics;";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        System.out.print("-->  " + resultSet.getString("TotalCount") + "명\n");
                    }
                    System.out.println();

                    // 문항 내 최대 갯수 번호 출력
                    System.out.println(" -- 문항 내에서 최대 갯수 번호");
                    query = "\r\n" + //
                            "SELECT t1.Question, t1.Answer\r\n" + //
                            "FROM (\r\n" + //
                            "    SELECT QUE.QUESTION AS 'Question', ANS.ANSWER AS 'Answer', COUNT(*) AS 'Count'\r\n" + //
                            "    FROM statistics AS STT\r\n" + //
                            "    INNER JOIN question AS QUE ON STT.QUESTION_ID = QUE.QUESTION_ID\r\n" + //
                            "    INNER JOIN answer AS ANS ON STT.ANSWER_ID = ANS.ANSWER_ID\r\n" + //
                            "    GROUP BY QUE.QUESTION, ANS.ANSWER\r\n" + //
                            ") AS t1\r\n" + //
                            "WHERE t1.Count = (\r\n" + //
                            "    SELECT MAX(t2.Count)\r\n" + //
                            "    FROM (\r\n" + //
                            "        SELECT QUE.QUESTION AS 'Question', ANS.ANSWER AS 'Answer', COUNT(*) AS 'Count'\r\n"
                            + //
                            "        FROM statistics AS STT\r\n" + //
                            "        INNER JOIN question AS QUE ON STT.QUESTION_ID = QUE.QUESTION_ID\r\n" + //
                            "        INNER JOIN answer AS ANS ON STT.ANSWER_ID = ANS.ANSWER_ID\r\n" + //
                            "        GROUP BY QUE.QUESTION, ANS.ANSWER\r\n" + //
                            "    ) AS t2\r\n" + //
                            ")";

                    resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("Question") + "-->  " + resultSet.getString("Answer"));
                    }
                    System.out.println();

                    // 답항 중심
                    System.out.println(" -- 답항 중심 ");
                    query = "SELECT ANS.ANSWER,STT.ANSWER_ID, COUNT(*) AS CNT\n" + //
                            "FROM pollswithdb.statistics as STT\n" + //
                            "INNER JOIN answer as ANS on STT.ANSWER_ID = ANS.ANSWER_ID\n" + //
                            "GROUP BY ANS.ANSWER_ID";

                    resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("ANSWER") + "-->  " + resultSet.getString("CNT"));
                    }
                    System.out.println();

                } else {
                    System.out.println(" ----- 작업 키 확인 ----" + workkey); // 작업키 안되면 작동
                }

            }

            System.out.println("----- 설문종료 -----");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error occurred while executing the query: " + e.getMessage());
        }
        System.out.println();
    }

}