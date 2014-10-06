<%@page import="com.org.prizy.master.ProductList"%>
<%@page import="java.util.List"%>
<form class="listproduct" method="">
    <ul>
        <li>Name</li>
        <li>Barcode</li>
        <li>Description</li>
    </ul>
    <% 
        List<ProductList> list = (List<ProductList>)request.getAttribute("items");
        for(ProductList e : list) {
    %>
    <ul>
        <li><%=e.getName() %></li>
        <li><img src="<%=e.getBarcode() %>" alt="" /></li>
        <li><%=e.getDescription() %></li>
    </ul>
    <% } %>
    
</form>