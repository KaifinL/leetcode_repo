class Solution {
    private void addIp(List<String> result, StringBuilder temp, int remain_dots, String s, int index) {
        if (s.length()==index && remain_dots==0) {
            temp = temp.deleteCharAt(temp.length()-1);
            result.add(temp.toString());
            temp.append(".");
        } else if ((remain_dots==0 && s.length()!=index) || 
            (remain_dots!=0 && s.length()==index) || (s.length()-index > (remain_dots)*3)) {
            return;
        } else {
            temp.append(s.substring(index, index+1));
            temp.append(".");
            addIp(result, temp, remain_dots-1, s, index+1);
            temp = temp.delete(temp.length()-2, temp.length());
            if (Integer.parseInt(s.substring(index, index+1)) != 0) {
                if (index < s.length()-1) {
                    temp.append(s.substring(index, index+2));
                    temp.append(".");
                    addIp(result, temp, remain_dots-1, s, index+2);
                    temp = temp.delete(temp.length()-3, temp.length());
                } 
                if (index < s.length()-2 && Integer.parseInt(s.substring(index, index+3)) <= 255) {
                    temp.append(s.substring(index, index+3));
                    temp.append(".");
                    addIp(result, temp, remain_dots-1, s, index+3);
                    temp = temp.delete(temp.length()-4, temp.length());
                }
            }

        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        addIp(result, new StringBuilder(), 4, s, 0);
        return result;
    }
}