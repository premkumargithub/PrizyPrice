<%@page import="com.org.prizy.master.Product"%>
<%@page import="java.util.List"%>
<form action="view" name="product" method="POST" onsubmit="return getProductDetail">
    <ul>
        <li>
            <label>Select Product</label>
            <label class="value">
                <select name="productid" id="viewproductId">
                    <option value="0">-- Select Product --</option>
                    <% 
                    List<Product> item = (List<Product>)request.getAttribute("items");
                    for(Product e : item) {
                    %>
                    <option value="<%=e.getProductId() %>"><%=e.getName()%></option>
                    <% } %>
                </select>
            </label>
        </li>
        
        <li>
            <label> </label>
            <input type="submit" name="submit" value="Get Product"/>
        </li>
    </ul>
</form>