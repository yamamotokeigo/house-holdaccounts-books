# house-holdaccounts-books

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
