
#
# Flex Example RFP
#

クライアントは、「dbflute-flexclient-example」
サーバは、「dbflute-flexserver-example」
データベースは、「dbflute-flexserver-example」内の「H2 Database」

基本は、dbflute-teeda-exampleで実装されている画面をFlexを使って実現すること。
よって、サーバサイドの処理(SQLなど)はdbflute-teeda-exampleのものをほとんど流用できる。
しかしながら、Flexはリッチクライアントが実現可能であり、かつ、DBFluteとFlexの連携で
強調したいのはFlexDtoの存在である。よって、SQLの実行はサーバで行い、
FlexDto経由でクライアント側にデータを渡し、画面ロジックは全てFlex側にて実装するのが好ましい。

現状(2008/09/22)、FlexのDtoは自動生成しているが、それ以外のクラスは存在しない。
dbflute-teeda-exampleを元にプロジェクトを作っているため、Flexには不要なファイルが
あるかもしれないが、消してもOK。WEBプロジェクトっぽい構成になっている可能性があるが、
それをFlex用に変更しても構わない。
