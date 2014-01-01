
# ========================================================================================
#                                                                                 Overview
#                                                                                 ========
The example project for Ymir and DBFlute.

このExampleには以下の目的があります：
  o 組み合わせた場合のおおよそのイメージを掴んでもらうこと
  o 環境構築の面における参考プロジェクトになること
  o ちょっとした検証などが可能な環境の提供

主な注意点としては、画面の作り込みはそんなに深くないということです。
「ロジックの再利用」や「排他制御」、「その他要件次第で変わる細かい動作・構成」など
Exampleならではの割り切りが存在していますので、実際のプロジェクトにおいては、
プロジェクトポリシーに合わせて実装して下さい。


# ========================================================================================
#                                                                              Environment
#                                                                              ===========
[Maven2]
This example DOES NOT use Maven2 so you don't need maven2 environment.

[H2]
It is embedded so you don't need to prepare and boot it. 


# ========================================================================================
#                                                                              Information
#                                                                              ===========
# ----------------------------------------------------------
#                                                Example URL
#                                                -----------
会員検索画面のURL：
http://localhost:8080/dbflute-ymir-example/member/search/list.html

# ----------------------------------------------------------
#                                              Example Class
#                                              -------------
会員検索画面のクラス：
src/main/java/com/example/dbflute/ymir/web/member/search/ListPage.java

会員検索画面のページクラスです。こちらが参考実装となります。

# ----------------------------------------------------------
#                                          Easy Introduction
#                                          -----------------
[Ymirの大きな特徴]
  A. HTMLテンプレート(+ 自由度高い)
  B. PRGパターン(+ Forwardもできる)
  C. HotDeploy(+ 自動生成結果も即反映)
  D. スコープ管理(+ 自由度高い)
  E. Pageクラスの自動生成(+ GenerationGap)

全体的に現場で必要な「いざって時の回避」が可能になっており、
それぞれの魅力的な機能を現場にフィットさせやすい構成になっています。
(特に「A」や「B」や「C」に関しては一般的に自由度が問題になりやすいところ)

[Ymirの開発スタイル]
  1. HTMLを作成(外部設計時など)
  2. HTMLをZPT化
  3. アプリを起動してブラウザから該当HTMLへアクセス
  4. ブラウザ上で該当Pageクラスを自動生成
  5. Pageクラスに処理を書いて実行して動作確認
  (x. 変更があった場合はHTMLを直して再自動生成)

基本的にアプリは起動しっ放しで開発します。

# ----------------------------------------------------------
#                                       プロパティの型のポリシー
#                                       --------------------
リクエストパラメータを受け取るPageクラスのプロパティの型のポリシーについて

大きく二つあって、
  A. 全てString型
  B. Integer型やDate型などを積極利用
　※boolean型はどのポリシーでも利用しますのでここでの話からは除外されます。

「A」は、自分で変換処理を行うため、プログラム上での多少の煩雑さを伴います。
また、日付に関しては、日付フォーマットを「制約のためのもの」と「表示のためのもの」で
プログラム上でニ箇所指定する必要があります。

「B」は、Integer型やDate型などであることを意識して作業する必要があります。
  B-1. 自動生成画面で一つ一つ型を指定していく(デフォルトが全てStringなため)
  B-2. 入力項目の場合はZPT上でPageクラスだけなくRequestParameterも参照する
       (バリデーションエラー時の再描画でエラーになった値を表示するため)
その代わり、プログラム上での型違いによる煩雑さはなく、かつ、
日付フォーマットは「制約のためのもの」と「表示のためのもの」が一つになります。
(Setterに付けたフォーマットが両方を兼ねる)

Exampleポリシーとして、「B」を利用しています。
数値と日付に関しては一つ一つ型を変更します。その後、必ずPageクラスのSetterを
オーバーライドして、@Numericもしくは@Datetime("yyyy/MM/dd")を付与します。
これは、制約だけでなく表示フォーマットも兼任しています。

ちなみに「B-2」の具体的なやり方ですが、
ZPT上で通常「value self/fooDate」と書くところを「value param-self/fooDate」と
書くようにします。前者は「Pageクラスのプロパティ」から値を取得しますが、
後者はそれに加えて「RequestParameter」からも値を取得します。(Request優先)

# ----------------------------------------------------------
#                                       バリデーションのポリシー
#                                       --------------------
「必須」と「サイズ」に関しては、postメソッドのアノテーションで実装しています。
「Numeric」や「Datetime」のような「型の制約」に関してはSetterで実装し、
チェックが実行されて欲しくないpostメソッドに対して
「@SuppressConstraints(ConstraintType.VALIDATION)」を付与します。

# ----------------------------------------------------------
#                                    tal属性の記述場所のポリシー
#                                    -----------------------
HTMLタグ上でtal属性をどこに記述するかのポリシーですが、

　o tal属性の「左は静的属性」
　o tal属性の「右はダミー属性(tal:attributesで実行時に差し替えられる)」

  ex.
  <input type="text" name="foo" tal:attributes="value cond/foo" value="dummy">

というように、Exampleでは書いております。
このように書かなくても動作はしますが、あまりに皆がバラバラな順序で書くと
可読性が悪くなるため、上記のような機械的に判断できて直感的なポリシーがお奨めです。

# ----------------------------------------------------------
#                                       DTO-Entity Converter
#                                       --------------------
DTOのEntityのコンバートは、リフレクションを使いません。
かといって、手動で全てGet/Setを書く訳でもありません。
指定されたDTOとEntityで同じ名前のプロパティのGet/Set処理をYmir自身が自動生成します。
自動生成画面でDTOを生成対象になったときに「対応するクラス」の項目に該当のEntityの名前を
指定することで、Converterが自動生成されます。
同名プロパティに関しては、特に何もする必要はありません。そうでないプロパティ同士は
Converterのサブクラスにてコピーメソッド(copyEntityToDto() or copyDtoToEntity())を
オーバーライドして処理を追加します。

Converterのメソッド：

toDtoList() / toEntityList() [リスト変換]
  |- copyEntityToDto() / copyDtoToEntity() [一件変換] *1
      |- reflectFooToDto() / reflectFooToEntity() [各プロパティごと]
          |- extractFooFromEntity() / extractFooFromDto() [プロパティ値取得] *2

  *1: 同名プロパティ以外のプロパティの変換のためのオーバーライドポイント
  *2: 型変換カスタマイズのためのオーバーライドポイント

# ----------------------------------------------------------
#                                          テンプレート編集機能
#                                          -----------------
アプリが表示したブラウザ上の画面をダブルクリックすると、テンプレート編集が
その場で出来る画面が表示されますが、この機能をOFFにするためには、
app.propertiesに以下を追加します。

extension.sourceCreator.enableInplaceEditor = false

ブラウザ上でのHTML編集は実業務で不要と判断した場合はこの設定をして下さい。
app.propertiesに関してはこちら：
http://ymir.seasar.org/docs/1.0.x/ref/appProperties

# ----------------------------------------------------------
#                                                Code Format
#                                                -----------
DBFlute標準のフォーマット定義を利用しています。
Eclipseのデフォルトから主に二つの項目を変更しています。
　o コメントはフォーマットしない
　o マージンを「80」から「120」に
こちらは好みですが、コメントはフォーマットされると困ることが多いため、
OFFにしております。（タグコメントの空白が除去されたりなど）
Eclipseのデフォルトをそのまま使われている方は、dbflute-ymir-example直下の
「formatter-profile.xml」をインポートして試してみるのも良いかと思います。


# ========================================================================================
#                                                                                    Other
#                                                                                    =====
# ----------------------------------------------------------
#                                                   Internal
#                                                   --------
YmirのSNAPSHOTのMaven2リポジトリ
http://maven.seasar.org/maven2-snapshot/org/seasar/ymir/
http://maven.seasar.org/maven2-snapshot/org/seasar/ymir/ymir-core/
http://maven.seasar.org/maven2-snapshot/org/seasar/ymir/ymir-extension/
http://maven.seasar.org/maven2-snapshot/org/seasar/ymir/ymir-zpt/
http://maven.seasar.org/maven2-snapshot/net/skirnir/freyja/freyja/

ZPTに詳しいサイト
http://www.webcore.co.jp/techinfo/misc/AdvancedPageTemplate.html

Oracleと8080がバッティングしてる場合 (Tomcatを8088に)
http://localhost:8088/dbflute-ymir-example/member/search/list.html
