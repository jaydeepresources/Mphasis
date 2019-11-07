import { PostsService } from './../posts.service';
import { Post } from './../model/Post';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  newPost: Post

  constructor(public postsService: PostsService) {
    this.newPost = new Post()
  }

  ngOnInit() {
  }

  addPost(addForm) {
    this.postsService.addPost(this.newPost)
    .subscribe((data:Post) => {
      this.postsService.posts.unshift(data)
      addForm.form.markAsPristine()
      this.newPost = new Post()
    })
  }

}
