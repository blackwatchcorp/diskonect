<form hx-post="post" hx-target="#create-post-container" hx-swap="innerHTML">
  <div>
    <label>Title</label>
    <input type="text" name="title" value="" required>
  </div>
  <div>
    <label>Content</label>
    <input type="text" name="content" value="" required>
  </div>

  <button class="btn">Submit</button>
  <button class="btn" hx-get="create-post-btn">Cancel</button>
</form>
