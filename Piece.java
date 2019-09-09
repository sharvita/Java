public class Piece {

    int color;
    boolean top = false;
    boolean bottom = false;
    boolean left = false;
    boolean right = false;

    Piece (){
        color =0;
        top = false;
        bottom = false;
        right= false;
        left = false;
    }

    Piece(int _color, boolean _top, boolean _bottom, boolean _right, boolean _left){
        color = _color;
        top = _top;
        bottom =_bottom;
        right =_right;
        left =_left;
    }

    public Piece flipColors(Piece a) {
        if (a.color == 1)
            a.color = 0;
        else if (a.color == 0)
            a.color = 1;
        else
            a.color = a.color;
        return a;
    }

}
