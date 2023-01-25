<%
    int idservice=Integer.parseInt(request.getParameter("idservice"));
%>

<div class="card shadow" style="margin-top: 50px">
  <div class="card-body">
    <h1>Modification taux</h1>
    <form method="POST" action="modifTaux">
        <div class="row">
             <input type="hidden" name="idservice" value="<%= idservice %>">
             
            <div class="col-4">
                <label>Taux </label>
                <input type="text" class="form-control" name="taux" style="width:400px   ">
            </div>
        <br/>
        <input type="submit" class="btn btn-primary" value="Valider">
    </form>
  </div>
</div>
