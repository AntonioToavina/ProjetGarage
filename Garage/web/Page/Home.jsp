<%@page import="Model.NiveauEtude"%>
<%@page import="Model.Specialite"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Specialite> specialite=(ArrayList<Specialite>)request.getAttribute("listspecialite");
    ArrayList<NiveauEtude>niveauEtude=(ArrayList<NiveauEtude>)request.getAttribute("listniveau");
%>

<div class="card shadow" style="margin-top: 50px" >
    <div class="card-body">
        <h1>Nouveau employe</h1>
        <form method="POST" action="newEmploye">
            <div class="row">
                <input type="hidden" name="idcarree" id="idcarree" value="${idcarree}">
                <div class="col-4">
                    <label>Nom </label>
                    <input type="text" class="form-control" name="nom" style="width:400px   ">
                </div>

                <div class="col-4">
                    <label>Prenom</label>
                    <input type="text" class="form-control" name="prenom" style="width:400px">
                </div>
                <br>

                <div class="col-4">
                    <label>Date de naissance</label>
                    <input type="date" class="form-control" name="dn" style="width:400px">
                </div>
                
                
                <div class="col-4" style="margin-top: 60px">
                    <h2>Specialite</h2>
                    <%
                        for(Specialite list : specialite){%>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="<%= list.getIdSpecialite() %>" name="specialite[]" />
                                <label class="form-check-label"><%= list.getLibelle() %></label>   
                            </div>
                            
                        <%}
                    %>
                </div>
                
                <div class="col-4" style="margin-top: 60px">
                    <label>Niveau etude</label>
                    <select class="form-control" name="niveauetude">
                        <%
                            for(NiveauEtude list : niveauEtude){%>
                                <option value="<%= list.getIdNiveauEtude() %>"><%= list.getLibelle() %></option>
                            <%}
                        %>
                    </select>
                </div>
                <br>
            </div>
            <br/>
            <input type="submit" class="btn btn-primary" value="Valider">
        </form>
    </div>
</div>