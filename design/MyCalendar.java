



class MyCalendar {

    private List<Integer> starts;
    private List<Integer> ends;

    public MyCalendar() {
        this.starts = new ArrayList();
        this.ends = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < this.starts.size(); i++) {
            int curr_start = this.starts.get(i);
            int curr_end = this.ends.get(i);
            if (end <= curr_start) {
                this.starts.add(i, start);
                this.ends.add(i, end);
                return true;
            } else if (start >= curr_end) {
                continue;
            } else {
                return false;
            }
        }
        this.starts.add(start);
        this.ends.add(end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */