import { Status } from './../model/Status';
import { Post } from './../model/Post';
import { PostsService } from './../posts.service';
import { AuthenticateService } from './../authenticate.service';
import { Router, Event, NavigationEnd } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  progressFlag: boolean

  constructor(public router: Router, public authService: AuthenticateService, public postsService: PostsService) {

    this.progressFlag = true

    var sub = this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd && !authService.loginStatus) {
        router.navigateByUrl('/signin').then(res => sub.unsubscribe())
      }
      else {
        this.progressFlag = true
        postsService.getPosts().subscribe((data: Post[]) => {
          this.postsService.posts = data
          this.progressFlag = false
        })
      }
    })

  }

  ngOnInit() {
  }

  postCopy(post: Post) {
    var obj: Post = new Post()
    obj.id = post.id
    obj.title = post.title
    obj.body = post.body

    return obj
  }

  delete(id: number, i: number) {
    this.postsService.deletePost(id)
      .subscribe((data: Status) => {
        if (data.queryStatus) {
          this.postsService.posts.splice(i, 1)
        }
      })
  }

}
