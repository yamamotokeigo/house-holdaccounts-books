# house-holdaccounts-books

<detail>
  ```mermaid
 sequenceDiagram
  actor User
  participant Controller
  participant Service
  participant Repository
  participant DB
 
  User ->> Controller : findShoppingList /update
  Controller ->> DB : ショッピングカート情報問い合わせ
  DB ->> Controller    : ショッピングカート情報送信
  Controller ->> Service : 宛先情報をフォームへセット
  Service ->> Repository : 宛先情報を送る
  Repository ->> DB : 注文情報と宛先情報を格納
  Repository ->> DB : ショッピングカート情報削除
  DB ->> Repository : 注文情報を取得
  Repository ->> Service : 注文情報を送る
  Service ->> Controller : 最新の注文情報を送る
  Controller ->> User : HTTPレスポンス   
   ```
</detail>
