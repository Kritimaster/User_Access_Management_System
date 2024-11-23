<form action="RequestServlet" method="post">
    <label for="softwareId">Software</label><select name="softwareId">
        <option value="1">Software 1</option>
        <option value="2">Software 2</option>
    </select>
    <label for="accessType">Access Type</label>
    <select name="accessType">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <label for="reason">Reason</label><textarea name="reason"></textarea>
    <input type="submit" value="Request Access"/>
</form>
