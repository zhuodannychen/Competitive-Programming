class Solution {
    public boolean isValid(String s) {
        String arr[] = s.split("");
        Stack<String> stack = new Stack<>();
        stack.add(arr[0]);
        if(s.length() % 2 == 1)
            return false;
        if(s.length() == 0)
            return true;
        for(int i = 1; i < s.length(); i++) {
            if(arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{")) {
                stack.add(arr[i]);
            } else {
                String s1 = stack.pop();
                //System.out.println(s1);
                if(!s1.equals("(") && arr[i].equals(")")) {
                    System.out.println("1");
                    return false;
                }
                if(!s1.equals("{") && arr[i].equals("}")) {
                    System.out.println("2");
                    return false;
                }
                if(!s1.equals("[") && arr[i].equals("]")) {
                    System.out.println("3");
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("4");
            return false;
        }
        else
            return true;
    }
}
