class ReverseString {
    char[] _s;

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        this._s = s;
        helper(0, s.length - 1);
    }

    public void helper(int left, int right) {
        if (right <= left) {
            return;
        }
        char temp = this._s[left];
        this._s[left] = this._s[right];
        this._s[right] = temp;
        helper(left + 1, right - 1);
    }
}