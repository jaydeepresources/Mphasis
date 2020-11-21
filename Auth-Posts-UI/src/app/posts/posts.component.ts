import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { Status } from '../model/status';
import { AuthService } from '../services/auth.service';
import { CrudService } from '../services/crud.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  progressFlag: boolean

  constructor(public auth: AuthService, public crud: CrudService) { }

  ngOnInit(): void {
    this.progressFlag = true
    this.crud.getPosts().subscribe((dbPosts: Post[]) => {
      this.crud.posts = dbPosts
      this.progressFlag = false
    })
  }

  deletePost(id) {
    this.crud.deletePost(id).subscribe((res: Status) => {
      if (res && res.resultStatus) {
        this.crud.getPosts().subscribe((dbPosts: Post[]) => {
          this.crud.posts = dbPosts
        })
      }
    })
  }

}
