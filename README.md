# house-holdaccounts-books

・新規登録
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

・年別月別集計
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
