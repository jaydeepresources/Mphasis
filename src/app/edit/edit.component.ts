import { PostsService } from './../posts.service';
import { Post } from './../model/Post';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  @Input()
  editedPost: Post

  @Input()
  index: number

  successFlag: boolean

  constructor(public service: PostsService) {
    this.successFlag = false
  }

  ngOnInit() {

  }

  editPost(editForm) {

    var obj: Post = new Post()

    obj.id = this.editedPost.id
    obj.title = editForm.form.value.title
    obj.body = editForm.form.value.body

    this.service.editPost(obj)
      .subscribe((data: Post) => {
        console.log(data)
        this.service.posts[this.index].id = obj.id
        this.service.posts[this.index].title = obj.title
        this.service.posts[this.index].body = obj.body
        editForm.form.markAsPristine()
        this.successFlag = true
      })
  }

}
