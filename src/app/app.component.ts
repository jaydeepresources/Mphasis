import { PostsService } from './posts.service';
import { Post } from './model/Post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  posts: Post[]
  progressFlag: boolean

  constructor(public service: PostsService) {
    this.progressFlag = true
    service.getPosts().subscribe((data: Post[]) => {
      this.posts = data
      this.progressFlag = false
    })
  }

}