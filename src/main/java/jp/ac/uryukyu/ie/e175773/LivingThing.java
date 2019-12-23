package jp.ac.uryukyu.ie.e175773;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     *コンストラクタ
     * @param name:名前
     * @param maximumHP:最大HP
     * @param attack:攻撃力
     */

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 死んでいるのかを判定するメソッド
     * @return boolean型,Trueなら死亡判定
     */

    public boolean isDead() {
        return dead;
    }

    /**
     * 名前を戻り値とするゲッターメソッド
     * @return:名前
     */

    public String getName() {
        return name;
    }

    /**
     * 敵を攻撃してダメージを与えるattackメソッド
     * @param opponent:相手キャラ
     */

    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        if (dead) {
            damage = 0;
        } else {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * hitPointのゲッター
     * @return HP
     */

    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * hitPointのセッター
     * @param hitPoint:HP
     */

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * attackのゲッター
     * @return
     */
    public int getAttack(){
        return attack;
    }

    /**
     * attckのセッター
     * @param attack:与えたダメージ(攻撃力)
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * deadのゲッター
     * @return
     */
    public boolean getDead(){
        return dead;
    }

    /**
     * deadのセッター
     * @param dead:生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 自分の合計ダメージを計算するメソッド
     * @param damage:ダメージ
     */

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
