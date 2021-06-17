*** Settings ***
Library  RequestsLibrary

*** Variable ***
${BASE_URL}  http://localhost:8082/api/movies
*** Test Cases ***

TC_001_Get_All_Movies
    Create Session  Get_All_Movies  ${BASE_URL}
    ${resp}=  Get On Session  Get_All_Movies  /
    Status Should Be    200    ${resp}
    Should Be Equal As Strings  ${resp.status_code}  200

TC_002_Create_Movie
    Create Session  Create_Movie  ${BASE_URL}
    &{data}=    Create Dictionary    id=123    name=bob    des=aaa    price=20
    ${resp}=    Post On Session    Create_Movie    /    json=${data}
    Should Be Equal As Strings    ${resp.status_code}    200
    ${jsondata}=    To Json    ${resp.content}
    log to console  ${jsondata}

*** Keywords ***
