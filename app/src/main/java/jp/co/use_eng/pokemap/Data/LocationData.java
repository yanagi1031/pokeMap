package jp.co.use_eng.pokemap.Data;

import jp.co.useeng.uselib.base.BaseObject;

/**
 * Created by kuroyanagi on 2016/08/26.
 */
public class LocationData extends BaseObject {

    public int      ID;                 //登録No
    public double   latitude;
    public double   longitude;
    public int      pokemonNo;
    public String   pokemonName;
    public int      goodCnt;
    public int      badCnt;
    public boolean  isGood;
    public boolean  isBad;
    public boolean  isMyAdd;            // 自分で追加したか　YES:削除可能　ピンを赤
    public String   trainer;
    public String   comment1;
    public String   comment2;
    public String   adress;
    public String   createDate;

}
