<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>

    #bestReview h3 { font-weight: 900; color: #4c4242;}

    #bestReview table {
        border-collapse: separate; /* 중첩된 테두리를 없앰 */
        border-spacing: 0;         /* 셀 간 간격을 없앰 */
        width: 100%;
        border-radius: 10px;       /* 테이블 전체 테두리 둥글게 */
        overflow: hidden;          /* 둥근 테두리가 잘리도록 처리 */
    }

    .review {
        padding: 10px;
        border: 2px solid #ddd;
    }

    #bestReview {
        padding: 20px 40px;
    }

    /* 각 행에 상하단 둥근 모서리 적용 */
    #bestReview tr:first-child th:first-child {
        border-top-left-radius: 10px;
    }
    #bestReview tr:first-child th:last-child {
        border-top-right-radius: 10px;
    }
    #bestReview tr:last-child td:first-child {
        border-bottom-left-radius: 10px;
    }
    #bestReview tr:last-child td:last-child {
        border-bottom-right-radius: 10px;
    }

    /* 각 행에 위아래 둥근 모서리 추가 */
    #bestReview tr td:first-child {
        border-top-left-radius: 10px;
        border-bottom-left-radius: 10px;
    }

    #bestReview tr td:last-child {
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
    }
</style>
</head>
<body>

    
    <div id="bestReview">
        <h3 align="center">BestReview</h3>
        <br>
        <table>
            <tbody></tbody>
        </table>
    </div>

    <script>
        $(function() {
            console.log("good...");
            bestReview();
        })

        function bestReview() {
            $.ajax ({
                url: 'bestReview',
                success: function(result) {

                    console.log(result);
                    if(result != null && result.length > 0) {

                        let reviewValue = "";
                        for (let r of result) {
                            reviewValue += "<tr class='review'>"
                                            + "<td class='review'>" + r.memberName + "</td>"
                                            + "<td class='review'>" + r.title + "</td>"
                                            + "<td class='review'>" + r.content + "</td>"
                                            + "<tr class='review'>";
                        }

                        $("#bestReview tbody").html(reviewValue);
                    }
                },
                error: function(err) {
                    console.log(err);
                }
            });
        }
    </script>

</body>
</html>