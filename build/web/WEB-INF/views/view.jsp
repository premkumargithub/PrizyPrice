<%@page import="com.org.prizy.master.ProductDetail"%>
<%@page import="java.util.List"%>
<form name="product" method="POST" onsubmit="add">
    <%
        List<ProductDetail> item = (List<ProductDetail>)request.getAttribute("data");
        for(ProductDetail e : item) {
            System.out.println("prem" + e.getName());
        %>
    <ul>
        <li>
            <label>Product Name </label>
            <label class="value"><%=e.getName()%></label>
        </li>
        <li>
            <label>Barcode </label>
            <label class="value"><img src="<%=e.getBarcode() %>" alt="" /></label>
        </li>
        <li>
            <label>Description </label>
            <label class="value"><%=e.getDescription() %></label>
        </li>
        <li>
            <label>Average Price </label>
            <label class="value"><%=e.getPrice() %></label>
        </li>
        <li>
            <label>Highest Price </label>
            <label class="value"><%=e.getHighestprice() %></label>
        </li>
        <li>
            <label>Lowest Price </label>
            <label class="value"><%=e.getLowestprice() %></label>
        </li>
        <li>
            <label>Ideal Price </label>
            <label class="value"><%=e.getIdelprice() %></label>
        </li>
        <% } %>
    </ul>
</form>
