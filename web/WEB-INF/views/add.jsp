<form action="saveProduct" name="product" method="POST" >
    <ul>
        <li>
            <label>Product Name </label>
            <input type="text" name="name" required/>
        </li>
        <li>
            <label>Description </label>
            <textarea  name="description" required></textarea>
        </li>
        <li>
            <label> </label>
            <input type="submit" name="submit" value="Add Product"/>
        </li>
    </ul>
</form>
