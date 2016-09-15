package jp.co.use_eng.pokemap.common;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String; import java.util.Date;

import jp.co.use_eng.pokemap.Data.PokemonData;
import jp.co.use_eng.pokemap.Data.PokemonDataList;
import jp.co.use_eng.pokemap.common.Server.Server;
import jp.co.use_eng.pokemap.common.Server.ServerResponce;
import jp.co.useeng.uselib.data.SerializeDataManager;
import jp.co.useeng.uselib.util.UtilDate;
import jp.co.useeng.uselib.util.UtilFile;

/**
 * Created by sn096 on 2015/08/27.
 */
//public class App extends jp.co.useeng.uselib.base.App {

/**
 * Created by kuroyanagi on 2016/08/19.
 */
public class App extends jp.co.useeng.uselib.base.App {

    public PokemonDataList pokemonDataList = null;

    private static App instance;
    public App() {
        instance = this;
    }
    public static App getInstance() {
        return instance;
    }

    public static void init(Context context) {

        // ポケモンリストの取得
//        try {
//            getInstance().pokemonDataList = (PokemonDataList) SerializeDataManager.getDataFromFile(context, Consts.FILENAME_POKEMON);
//        } catch (IOException e) {
//            e.getStackTrace();
//        }

        // 保存されていなければ初期化
        if (getInstance().pokemonDataList == null) {
            getInstance().pokemonDataList = new PokemonDataList();
            _createPokemon();
        }






    }







    // ポケモン情報の作成
    private static void _createPokemon() {
        
        PokemonData poke = new PokemonData();
        poke.No       = 1;
        poke.Name     = "フシギダネ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "チュートリアル";

        getInstance().pokemonDataList.add(poke);

        poke = new PokemonData();
        poke.No       = 2;
        poke.Name     = "フシギソウ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・フシギダネから進化";

        getInstance().pokemonDataList.add(poke);

        poke = new PokemonData();
        poke.No       = 3;
        poke.Name     = "フシギバナ";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・フシギソウから進化";

        getInstance().pokemonDataList.add(poke);

        poke = new PokemonData();
        poke.No       = 4;
        poke.Name     = "ヒトカゲ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

                getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 5;
        poke.Name     = "リザード";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ヒトカゲから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 6;
        poke.Name     = "リザードン";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・リザードから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 7;
        poke.Name     = "ゼニガメ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 8;
        poke.Name     = "カメール";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ゼニガメから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 9;
        poke.Name     = "カメックス";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・カメールから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 10;
        poke.Name     = "キャタピー";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 11;
        poke.Name     = "トランセル";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・キャタピーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 12;
        poke.Name     = "バタフリー";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・トランセルから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 13;
        poke.Name     = "ビードル";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 14;
        poke.Name     = "コクーン";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・ビードルから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 15;
        poke.Name     = "スピアー";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・コクーンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 16;
        poke.Name     = "ポッポ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 17;
        poke.Name     = "ピジョン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ポッポから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 18;
        poke.Name     = "ピジョット";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ピジョンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 19;
        poke.Name     = "コラッタ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 20;
        poke.Name     = "ラッタ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・コラッタから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 21;
        poke.Name     = "オニスズメ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 22;
        poke.Name     = "オニドリル";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・オニスズメから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 23;
        poke.Name     = "アーボ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 24;
        poke.Name     = "アーボック";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・アーボから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 25;
        poke.Name     = "ピカチュウ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 26;
        poke.Name     = "ライチュウ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ピカチュウから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 27;
        poke.Name     = "サンド";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 28;
        poke.Name     = "サンドパン";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・サンドから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 29;
        poke.Name     = "ニドラン♀";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 30;
        poke.Name     = "ニドリーナ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ニドラン♀から進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 31;
        poke.Name     = "ニドクイン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ニドリーナから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 32;
        poke.Name     = "ニドラン♂";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 33;
        poke.Name     = "ニドリーノ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ニドラン♂から進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 34;
        poke.Name     = "ニドキング";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ニドリーノから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 35;
        poke.Name     = "ピッピ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 36;
        poke.Name     = "ピクシー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ピッピから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 37;
        poke.Name     = "ロコン";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 38;
        poke.Name     = "キュウコン";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・ロコンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 39;
        poke.Name     = "プリン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 40;
        poke.Name     = "プクリン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・プリンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 41;
        poke.Name     = "ズバット";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 42;
        poke.Name     = "ゴルバット";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ズバットから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 43;
        poke.Name     = "ナゾノクサ";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 44;
        poke.Name     = "クサイハナ";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・ナゾノクサから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 45;
        poke.Name     = "ラフレシア";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・クサイハナから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 46;
        poke.Name     = "パラス";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 47;
        poke.Name     = "パラセクト";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・パラスから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 48;
        poke.Name     = "コンパン";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 49;
        poke.Name     = "モルフォン";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・コンパンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 50;
        poke.Name     = "ディグダ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 51;
        poke.Name     = "ダグトリオ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ディグダから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 52;
        poke.Name     = "ニャース";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 53;
        poke.Name     = "ペルシアン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ニャースから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 54;
        poke.Name     = "コダック";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 55;
        poke.Name     = "ゴルダック";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・コダックから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 56;
        poke.Name     = "マンキー";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 57;
        poke.Name     = "オコリザル";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・マンキーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 58;
        poke.Name     = "ガーディ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 59;
        poke.Name     = "ウインディ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ガーディから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 60;
        poke.Name     = "ニョロモ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 61;
        poke.Name     = "ニョロゾ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ニョロモから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 62;
        poke.Name     = "ニョロボン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ニョロゾから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 63;
        poke.Name     = "ケーシィ";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 64;
        poke.Name     = "ユンゲラー";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・ケーシィから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 65;
        poke.Name     = "フーディン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ユンゲラーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 66;
        poke.Name     = "ワンリキー";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 67;
        poke.Name     = "ゴーリキー";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ワンリキーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 68;
        poke.Name     = "カイリキー";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ゴーリキーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 69;
        poke.Name     = "マダツボミ";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 70;
        poke.Name     = "ウツドン";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・マダツボミから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 71;
        poke.Name     = "ウツボット";
        poke.comment1 = "・緑の多い場所で出現";
        poke.comment2 = "・ウツドンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 72;
        poke.Name     = "メノクラゲ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 73;
        poke.Name     = "ドククラゲ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・メノクラゲから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 74;
        poke.Name     = "イシツブテ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 75;
        poke.Name     = "ゴローン";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・イシツブテから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 76;
        poke.Name     = "ゴローニャ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ゴローンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 77;
        poke.Name     = "ポニータ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 78;
        poke.Name     = "ギャロップ";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・ポニータから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 79;
        poke.Name     = "ヤドン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 80;
        poke.Name     = "ヤドラン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ヤドンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 81;
        poke.Name     = "コイル";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 82;
        poke.Name     = "レアコイル";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・コイルから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 83;
        poke.Name     = "カモネギ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 84;
        poke.Name     = "ドードー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 85;
        poke.Name     = "ドードリオ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ドードーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 86;
        poke.Name     = "パウワウ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 87;
        poke.Name     = "ジュゴン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・パウワウから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 88;
        poke.Name     = "ベトベター";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 89;
        poke.Name     = "ベトベトン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ベトベターから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 90;
        poke.Name     = "シェルダー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 91;
        poke.Name     = "パルシェン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・シェルダーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 92;
        poke.Name     = "ゴース";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 93;
        poke.Name     = "ゴースト";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・ゴースから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 94;
        poke.Name     = "ゲンガー";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・ゴーストから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 95;
        poke.Name     = "イワーク";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 96;
        poke.Name     = "スリープ";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 97;
        poke.Name     = "スリーパー";
        poke.comment1 = "・平地夜で出現";
        poke.comment2 = "・スリープから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 98;
        poke.Name     = "クラブ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 99;
        poke.Name     = "キングラー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・クラブから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 100;
        poke.Name     = "ビリリダマ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 101;
        poke.Name     = "マルマイン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ビリリダマから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 102;
        poke.Name     = "タマタマ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 103;
        poke.Name     = "ナッシー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマタマから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 104;
        poke.Name     = "カラカラ";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 105;
        poke.Name     = "ガラガラ";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・カラカラから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 106;
        poke.Name     = "サワムラー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 107;
        poke.Name     = "エビワラー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 108;
        poke.Name     = "ベロリンガ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 109;
        poke.Name     = "ドガース";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 110;
        poke.Name     = "マタドガス";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・ドガースから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 111;
        poke.Name     = "サイホーン";
        poke.comment1 = "・気温が高い場所で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 112;
        poke.Name     = "サイドン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・サイホーンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 113;
        poke.Name     = "ラッキー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 114;
        poke.Name     = "モンジャラ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 115;
        poke.Name     = "ガルーラ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 116;
        poke.Name     = "タッツー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 117;
        poke.Name     = "シードラ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タッツーから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 118;
        poke.Name     = "トサキント";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 119;
        poke.Name     = "アズマオウ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・トサキントから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 120;
        poke.Name     = "ヒトデマン";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 121;
        poke.Name     = "スターミー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ヒトデマンから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 122;
        poke.Name     = "バリヤード";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 123;
        poke.Name     = "ストライク";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 124;
        poke.Name     = "ルージュラ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 125;
        poke.Name     = "エレブー";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 126;
        poke.Name     = "ブーバー";
        poke.comment1 = "・気温の高い場所で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 127;
        poke.Name     = "カイロス";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 128;
        poke.Name     = "ケンタロス";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 129;
        poke.Name     = "コイキング";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(2km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 130;
        poke.Name     = "ギャラドス";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・コイキングから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 131;
        poke.Name     = "ラプラス";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 132;
        poke.Name     = "メタモン";
        poke.comment1 = "・調査中";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 133;
        poke.Name     = "イーブイ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 134;
        poke.Name     = "シャワーズ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・イーブイから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 135;
        poke.Name     = "サンダース";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・イーブイから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 136;
        poke.Name     = "ブースター";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・イーブイから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 137;
        poke.Name     = "ポリゴン";
        poke.comment1 = "・調査中";
        poke.comment2 = "・タマゴ孵化(5km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 138;
        poke.Name     = "オムナイト";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 139;
        poke.Name     = "オムスター";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・オムナイトから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 140;
        poke.Name     = "カブト";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 141;
        poke.Name     = "カブトプス";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・カブトから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 142;
        poke.Name     = "プテラ";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 143;
        poke.Name     = "カビゴン";
        poke.comment1 = "・平地で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 144;
        poke.Name     = "フリーザー";
        poke.comment1 = "・イベント入手？";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 145;
        poke.Name     = "サンダー";
        poke.comment1 = "・イベント入手？";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 146;
        poke.Name     = "ファイヤー";
        poke.comment1 = "・イベント入手？";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 147;
        poke.Name     = "ミニリュウ";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・タマゴ孵化(10km)";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 148;
        poke.Name     = "ハクリュー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ミニリュウから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 149;
        poke.Name     = "カイリュー";
        poke.comment1 = "・水辺で出現";
        poke.comment2 = "・ハクリューから進化";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 150;
        poke.Name     = "ミュウツー";
        poke.comment1 = "・イベント入手？";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke); 

        poke = new PokemonData();
        poke.No       = 151;
        poke.Name     = "ミュウ";
        poke.comment1 = "・イベント入手？";
        poke.comment2 = "";

        getInstance().pokemonDataList.add(poke);

        // ポケモン情報の保存
        _savePokemonDataList();
    }

    /**
     * ポケモンデータ保存
     */
    private static void _savePokemonDataList() {
        try {
            SerializeDataManager.setDataToFile(App.getAppContext(), getInstance().pokemonDataList, Consts.FILENAME_POKEMON);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}