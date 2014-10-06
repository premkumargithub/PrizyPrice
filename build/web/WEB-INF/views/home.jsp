<%@page import="com.org.prizy.master.Product"%>
<%@page import="java.util.List"%>
<form action="submitSurvey" method="POST" onsubmit="return submitSurvey()">
    <ul>
        <li>
            <label>Select Product to enter price</label>
            <select name="productid" onchange="checkSurvey()" id="productId">
                <option value="0"> --Select Product -- </option>
                <% 
                List<Product> item = (List<Product>)request.getAttribute("items");
                for(Product e : item) {
                %>
                <option value="<%=e.getProductId() %>"><%=e.getName() %></option>
                <% } %>
            </select>
        </li>  
    </ul>
    
    <ul id="survey-layout" style="display:none;">
        <li>
            <label>Enter Price to Product </label>
            <input type="text" name="price" id="price" required=""/>
        </li>
        <li>
            <label>Notes</label>
            <textarea name="notes" id="notes" required></textarea>
        </li>
        <li>
            <input type="submit" name="submit" value="Add Price"/>
        </li>
    </ul>
</form>
