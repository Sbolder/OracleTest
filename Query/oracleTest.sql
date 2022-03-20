---A) Write a SQL statement to list all customers who bought at least 10 pieces
---  of a single product in 2015. The result should consist of customer's name, 
---  name of the product and number of pieces they bought that year.

select c.Name, p.Name, t1.Amount
FROM

(select s.CustomerID, si.ProductID, si.Amount

from SalesItem si , Sales s
where s.TranID = si.TranID and si.Amount >10 and s.DateTime BETWEEN '2015-01-01 00:00:00' and '2015-12-31 23:59:59') t1
JOIN
Customers c ON (t1.CustomerID = c.CustomerID)
JOIN
Products p ON (t1.ProductID = p.ProductID)

---Write a SQL statement to return a list of ALL products kept in the database
---with the sum of sold pieces in years 2010-2015. Sort this list
---descendingly by the number of pieces and if two or more products have 
---the same amount, sort these alphabetically.

select p.ProductID, cc, Name
from
(
select si.ProductID, SUM(si.Amount) as cc

from sales s
join SalesItem si ON (s.TranID = si.TranID)
where s.DateTime BETWEEN '2010-01-01 00:00:00' and '2015-12-31 23:59:59' 
group by si.ProductID) t2
RIGHT OUTER JOIN Products p ON(p.ProductID = t2.ProductID)
order by cc desc, Name asc


---Write a SQL statement that returns the list of customers (customer's ID 
---and name) with the total sum of their purchases sorted by customer's name.
---Don't forget to find the correct price of a product valid for the date 
---of purchase.
   
select t5.CustomerID, t5.Name, SUM(t5.purchase) AS total
from 
(
 Select t4.CustomerID, c.Name, (t4.Amount * t4.Price) as purchase
  from
  (
  select t3.CustomerID, pp.ProductID, t3.Amount, pp.Price
  FROM
  (
  select t2.CustomerID, si.ProductID, t2.DateTime, si.Amount
  from
  (
  select t1.TranID, s.CustomerID, s.DateTime
  from
  (
  select distinct TranID
  from SalesItem 
  group by TranID) as t1 join Sales as s ON(t1.TranID = s.TranID)) t2 
  LEFT OUTER JOIN SalesItem si ON(t2.TranID = si.TranID)) t3
  JOIN ProductPrices pp ON (pp.ProductID = t3.ProductID)
  where t3.DateTime > pp.ValidFrom) t4
  JOIN Customers c ON (c.CustomerID =t4.CustomerID)
  ) t5
  group by t5.CustomerID, t5.Name
order by t5.Name asc