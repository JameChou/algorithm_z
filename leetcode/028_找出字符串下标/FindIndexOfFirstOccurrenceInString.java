public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }
}
