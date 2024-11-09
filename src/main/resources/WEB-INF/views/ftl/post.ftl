<div>
<#assign createdDateTime = post.createdAt()?datetime>
<#assign createdAt = createdDateTime?string["yyyy-MM-dd HH:mm"]>
<h3>${post.title()}</h3>
<small>${createdAt}</small>
<p>${post.content()}</p>
</div>
