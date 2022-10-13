# 家計簿アプリの開発

こちらは家計簿アプリのリポジトリとなります。Spring開発における基本機能の網羅を目的とした開発となっており、詳細は下記よりご確認ください。<br>

## 🖋主な機能
* 家計簿一覧表示機能
* 家計簿新規登録機能
* 家計簿更新機能
* 家計簿削除機能
* 年別、月別家計簿集計機能

## 🖥使用技術
* Java17
* JavaScript
* SQL
* HTML
* CSS
* SpringBoot(Spring MVC, Spring JDBC)
* Thymeleaf

## 🌸機能一覧
*家計簿新規登録
   <details>
     <summary>シーケンス図</summary>
  
  ```mermaid
 sequenceDiagram
  actor User
  participant Controller
  participant Service
  participant Repository
  participant DB
 
  User ->> Controller : insert
  Controller ->> DB : 家計簿情報問い合わせ
  DB ->> Controller    : 家計簿情報送信
  Controller ->> Service : 登録情報をセット
  Service ->> Repository : 登録情報を送る
  Repository ->> DB : 登録情報を格納
  DB ->> Repository : 登録情報を取得
  Repository ->> Service : 登録情報を送る
  Service ->> Controller : 最新の登録情報を送る
  Controller ->> User : HTTPレスポンス   
   ```
  </details>

*年別月別集計
  <details>
     <summary>シーケンス図</summary>
  
  ```mermaid
 sequenceDiagram
 actor User
  participant Controller
  participant Service
  participant Repository
  participant DB
 
  User ->> Controller : findByYearAndMonth
  Controller ->> DB : 家計簿情報問い合わせ
  DB ->> Controller    : 家計簿情報送信
  Controller ->> Service : 年月の検索情報をセット
  Service ->> Repository : 検索情報を送る
  Repository ->> DB : 検索情報を格納
  DB ->> Repository : 検索情報を取得
  Repository ->> Service : 年月の検索情報を送る
  Service ->> Controller : 検索情報を送る
  Controller ->> User : HTTPレスポンス   
   ```
  </details>
