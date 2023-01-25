<%@page import="Model.PrixService"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<PrixService> listPrix=(ArrayList<PrixService>)request.getAttribute("listprix");
%>

<div class="card shadow" style="margin-top: 50px">
  <div class="card-body">
    <h1>Listes details par service</h1>

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">Service</th>
          <th scope="col">Taux</th>
          <th scope="col">PrixRevient</th>
          <th scope="col">PrixVente</th>
           <th scope="col">Benefice</th>
        </tr>
      </thead>
      <tbody>
          <%
              for(PrixService service : listPrix){%>
                <tr>
                    <th scope="row"><%= service.getService().getNomService() %></th>
                    <td><a href="modifTaux?idservice=<%= service.getService().getIdService() %>"><%= service.getService().getTaux() %></a></td>
                    <td><%= service.getPrixRevient() %></td>
                    <td><%= service.getPrixVente() %> </td>
                    <td><%= service.getBenefice()%> </td>
                </tr>
              <%}
          %>
      </tbody>
    </table>
  </div>
</div>
