<%
    String linkPage=request.getParameter("page");
    if(linkPage==null){
        linkPage="Page/Home.jsp";
    }
%>
<jsp:include page="Template/Header.jsp" />
<jsp:include page="<%= linkPage %>" />

</div>
</div>
</div>
<a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
</div>
</body>
</html>