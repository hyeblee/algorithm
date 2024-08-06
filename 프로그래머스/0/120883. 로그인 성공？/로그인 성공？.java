class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        for(String[] user : db){
if(user[0].equals(id_pw[0])&&user[1].equals(id_pw[1]))
    return "login";
            else if(user[0].equals(id_pw[0]))
                return "wrong pw";
            
}
         return "fail";
    }
   
}