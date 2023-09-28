package amir.simo.myapplication3;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Categories {

    public List<String> categories_List;
    public String Titles;

    public Categories(){

    }
    public Categories(List<String> Menu,String Titles){
        this.categories_List=Menu;
        this.Titles=Titles;
    }
}
